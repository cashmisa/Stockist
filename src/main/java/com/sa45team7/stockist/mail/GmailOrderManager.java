package com.sa45team7.stockist.mail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.sa45team7.stockist.service.ReorderService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class GmailOrderManager implements OrderManager {

	@Value(value = "classpath:ReorderReportPerSupplier.jrxml")
	private Resource jasperFile;
	
	@Autowired
	public JavaMailSender mailSender;

	@Autowired
	ReorderService rService;

	@Override
	public void placeOrder(int supplierId) {

		String reportName = "ReorderReportPerSupplier";

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			JasperReport report = JasperCompileManager.compileReport(jasperFile.getInputStream());

			JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(
					rService.getReorderProductListBySupplier(supplierId));

			// Map to hold Jasper report Parameters
			Map<String, Object> parameters = new HashMap<String, Object>();
//			parameters.put("productData", jrds);

			// Using compiled version(.jasper) of Jasper report to generate PDF
			JasperPrint print = JasperFillManager.fillReport(report, parameters, jrds);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(print, baos);
			DataSource attachment =  new ByteArrayDataSource(baos.toByteArray(), "application/pdf");

			helper.setTo("matrixhero259@gmail.com");
			helper.setText("Test from Stockist");

			helper.addAttachment("report.pdf", attachment);
			mailSender.send(message);

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendSimpleMessage() {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo("matrixhero259@gmail.com");
			helper.setText("Test from Stockist");
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		// SimpleMailMessage message = new SimpleMailMessage();
		// message.setTo(to);
		// message.setSubject(subject);
		// message.setText(text);
		// emailSender.send(message);

	}
}
