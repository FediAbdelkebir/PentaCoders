package tn.esprit.workmood.services;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import lombok.AllArgsConstructor;
import tn.esprit.workmood.entities.Name;
import tn.esprit.workmood.entities.Role;
import tn.esprit.workmood.entities.User;
import tn.esprit.workmood.repositories.RoleRepository;
import tn.esprit.workmood.repositories.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInt {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	
	@Autowired
    public JavaMailSender emailSender;
	

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public User findUserByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}

	/*
	 * public User saveUser(User user) {
	 * user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
	 * user.setConfirmPasswd(bCryptPasswordEncoder.encode(user.getConfirmPasswd(
	 * ))); user.setEnabled(true); return userRepository.save(user); }
	 */

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void save(User user, Long idRole) {

		Role role = roleRepository.findById(idRole).get();

		user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
		user.setConfirmPasswd(bCryptPasswordEncoder.encode(user.getConfirmPasswd()));
		user.setEnabled(true);
		role.getUsers().add(user);
		userRepository.save(user);
		// user.setRoles(new HashSet<>(roleRepository.findAll()));

	}

	@Override
	public void deleteUser(Long id) {

		userRepository.deleteById(id);
	}

	@Override
	public void assignRolesToUser(Long idUser, Long idRole) {

		User user = userRepository.findById(idUser).get();
		Role role = roleRepository.findById(idRole).get();

		user.getRoles().add(role);
		userRepository.save(user);
	}

	@Override
	public List<User> retrieveUsers() {

		return userRepository.findAll();
	}

	@Override
	public User retriveUser(Long idUser) {

		return userRepository.findById(idUser).orElse(null);
	}

	@Override
	public User findUserByEmailAddress(String email) {
		return userRepository.findByEmailAddress(email);
	}

	@Override
	public User resetPasswd(String email) {
		User u = userRepository.findByEmailAddress(email);
		if (u==null){
			return (null);
		}
		Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

		String accessToken = JWT.create().withSubject(email)
				.withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
				.sign(algorithm);
		try {
			sendEmail(email ,accessToken);
		} catch (MailException e) {
			
			e.printStackTrace();
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		System.out.println("completed");
		return u;
	}

	private void sendEmail(String email , String accessToken) throws MailException, MessagingException {
		MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        String htmlMsg = "<!doctype html><html lang='en-US'><head><meta content='text/html; charset=utf-8' http-equiv='Content-Type' /><title>Reset Password Email Template</title><meta name='description' content='Reset Password Email Template.'><style type='text/css'>a:hover {text-decoration: underline !important;}</style></head><body marginheight='0' topmargin='0'marginwidth='0' style='margin: 0px; background-color: #f2f3f8;' leftmargin='0'><!--100% body table--><table cellspacing='0' border='0' cellpadding='0' width='100%' bgcolor='#f2f3f8'style='@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: '+'Open Sans'+', sans-serif;'><tr><td><table style='background-color: #f2f3f8; max-width:670px;  margin:0 auto;' width='100%' border='0'align='center' cellpadding='0' cellspacing='0'><tr><td style='height:80px;'>&nbsp;</td></tr><tr><td style='text-align:center;'><a href='https://rakeshmandal.com' title='logo' target='_blank'><img width='60' src='https://i.ibb.co/hL4XZp2/android-chrome-192x192.png' title='logo' alt='logo'></a></td></tr><tr><td style='height:20px;'>&nbsp;</td></tr><tr><td><table width='95%' border='0' align='center' cellpadding='0' cellspacing='0'style='max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);'><tr<td style='height:40px;'>&nbsp;</td></tr><tr><td style='padding:0 35px;'><h1 style='color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'+'Rubik'+',sans-serif;'>You haverequested to reset your password</h1><spanstyle='display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;'></span><p style='color:#455056; font-size:15px;line-height:24px; margin:0;'>We cannot simply send you your old password. A unique link to reset yourpassword has been generated for you. To reset your password, click thefollowing link and follow the instructions.</p><a href='mydomain/"+accessToken+"'style='background:#20e277;text-decoration:none !important; font-weight:500; margin-top:35px; color:#fff;text-transform:uppercase; font-size:14px;padding:10px 24px;display:inline-block;border-radius:50px;'>ResetPassword</a></td></tr><tr><td style='height:40px;'>&nbsp;</td></tr></table></td><tr><td style='height:20px;'>&nbsp;</td></tr><tr><td style='text-align:center;'><p style='font-size:14px; color:rgba(69, 80, 86, 0.7411764705882353); line-height:18px; margin:0 0 0;'>&copy; <strong>www.rakeshmandal.com</strong></p></td></tr><tr><td style='height:80px;'>&nbsp;</td></tr></table></td></tr></table><!--/100% body table--></body></html>";

        message.setContent(htmlMsg, "text/html");

        helper.setTo(email);
        helper.setSubject("Test send HTML email");


        this.emailSender.send(message);
		
    
	}

	@Override
	public int findByUserRoleAdmin() {
		
		return userRepository.findByRolesName(Name.ADMIN).size();
		
	}
	@Override
	public int findByUserRoleEmployee() {
		
		return userRepository.findByRolesName(Name.EMPLOYEE).size();
		
	}

	@Override
	public int findByUserRoleManager() {
		
		return userRepository.findByRolesName(Name.MANAGER).size();
		
	}


}
