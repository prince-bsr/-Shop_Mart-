package com.ecom.util;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ecom.model.ProductOrder;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class CommonUtil {

	@Autowired
	private  JavaMailSender mailSender;
	
	public  Boolean sendMail(String url,String reciepentEmail) throws UnsupportedEncodingException, MessagingException
	{
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("bhawanirajput1226@gmail.com", "ShopCart");
		helper.setTo(reciepentEmail);

		String content = "<p>Hello,</p>" + "<p>You have requested to reset your password.</p>"
				+ "<p>Click the link below to change your password:</p>" + "<p><a href=\"" + url
				+ "\">Change my password</a></p>";
		helper.setSubject("Password Reset");
		helper.setText(content, true);
		mailSender.send(message);
		return true;
	}

	public  String generateUrl(HttpServletRequest request) {
		
		String siteUrl = request.getRequestURL().toString();

		return siteUrl.replace(request.getServletPath(), "");
		
	}
	
	String msg = null;

	public Boolean sendMailForProductOrder(ProductOrder order, String status)
			throws MessagingException, UnsupportedEncodingException {

		msg = "<p>Hello <p>[[name]]</p> Your order <b>[[orderStatus]]</b>. </p>" + "<p><b> Products Details : </b></p>"
				+ "<p>Name : [[productName]]</p>" + "<p>Category : [[category]]</p>" + "<p>Quantity : [[quantity]]</p>"
				+ "<p>Price : [[price]]</p>" + "<p>payment Type : [[paymentType]]</p>";

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("bhawanirajput1226@gmail.com", "ShopMart");
		helper.setTo(order.getOrderAddress().getEmail());

		msg = msg.replace("[[name]]", order.getOrderAddress().getFirstName());
		msg = msg.replace("[[orderStatus]]", status);
		msg = msg.replace("[[productName]]", order.getProduct().getTitle());
		msg = msg.replace("[[category]]", order.getProduct().getCategory());
		msg = msg.replace("[[quantity]]", order.getQuantity().toString());
		msg = msg.replace("[[price]]", order.getPrice().toString());
		msg = msg.replace("[[paymentType]]", order.getPaymentType());

		helper.setSubject("Product Order Status");
		helper.setText(msg, true);
		mailSender.send(message);

		return true;
	}

}
