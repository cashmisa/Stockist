package com.sa45team7.stockist.mail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.sa45team7.stockist.model.Supplier;
import com.sa45team7.stockist.service.ReportService;
import com.sa45team7.stockist.service.SupplierService;

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
	ReportService rService;

	@Autowired
	SupplierService sService;

	@Override
	public void placeOrder(int supplierId) {

		Supplier supplier = sService.findSupplier(supplierId);
		String supplierName = supplier.getSupplierName();
		String supplierContactName = supplier.getContactName();
		String supplierEmail = supplier.getEmail();
		String subject = "[Stockist] Order to " + supplierName;

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(new InternetAddress("sa45team7@gmail.com", "Stockist"));
			helper.setTo(supplierEmail);
			helper.setBcc("matrixhero259@gmail.com");
			helper.setSubject(subject);
			helper.setText("Dear " + supplierContactName + ",\n\nPlease take our order as in attachment.\n\nBest regards,\nStockist");

			JasperReport report = JasperCompileManager.compileReport(jasperFile.getInputStream());

			JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(
					rService.findReorderDTOListBySupplier(supplierId));

			// Using compiled version(.jasper) of Jasper report to generate PDF
			JasperPrint print = JasperFillManager.fillReport(report, null, jrds);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(print, baos);
			DataSource attachment = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");

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

}
