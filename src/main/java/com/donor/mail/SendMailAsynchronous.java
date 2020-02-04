package com.donor.mail;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * Class that sends mail asynchronously.
 * 
 * <p>
 * This class sends mail using given parameters. 
 * As it extends Thread, you should create a new object of this class and then call {@link #start()} to send the mail.
 * </p>
 * 
 * @author Ruchita Bhamare
 */
public class SendMailAsynchronous extends Thread {

	/** The logger. */
	private final Logger log = Logger.getLogger(SendMailAsynchronous.class);
	
	/** The subject. */
	private String email, body, subject;

	/** The pdf. */
	private File pdf;

	/**
	 * Instantiates a new mail sender.
	 */
	public SendMailAsynchronous() {
	
	}

	/**
	 * Instantiates a new mail sender.
	 * 
	 * @param em
	 *            the email
	 * @param bd
	 *            the body
	 * @param sub
	 *            the subject
	 * @param file
	 *            the pdf (can be null)
	 */
	public SendMailAsynchronous(final String em, final String bd, final String sub, final File file) {
		this.email = em;
		this.body = bd;
		this.subject = sub;
		this.pdf = file;		
	}

	/**
	 * Sends Email in a Separate Thread.
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public final void run() {
		SendMailSynchronous sendMailSynchronous = new SendMailSynchronous();
		try {
			if (pdf != null) {
				sendMailSynchronous.sendMail(email, body, subject, pdf);
			} else {
				sendMailSynchronous.sendMail(email, body, subject);
			}
		} catch (Exception e) {
			log.error("", e);
		}
	}
}
