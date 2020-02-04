package com.donor.config;


/**
 * Provides configuration constants.
 * 
 * @author Ruchita Bhamare
 */
public final class ConfigKey {

	/**
	 * Instantiates a new config key.
	 */
	private ConfigKey() {
		super();
	}

	/** The Constant CONFIG_PATH. */
	public static final String CONFIG_PATH = "config.path";

	/** The Constant VERBOSE_MODE. */
	public static final String VERBOSE_MODE = "verbose.mode";

	/** The Constant SERVICEMAPPING_TIMER. */
	public static final String SERVICEMAPPING_TIMER = "servicemapping.timer";

	/** The Constant MQ_BROKER. */
	public static final String MQ_BROKER = "mq.broker";

	/** The Constant MQ_UMAP_REQ. */
	public static final String MQ_UMAP_REQ = "mq.requests";

	/** The Constant MQ_ENABLE. */
	public static final String MQ_ENABLE = "mq.enable";

	/** The Constant MQ_UMAP_IMAGE. */
	public static final String MQ_UMAP_IMAGE = "mq.image.requests";

	/** The Constant ANALYTICS_IMPL_CLASSES. */
	public static final String ANALYTICS_IMPL_CLASSES = "umap.request.analyzer.class";

	/** The Constant ANALYTICS_ENABLED. */
	public static final String ANALYTICS_ENABLED = "umap.analytics.enabled";

	/** The Constant IMAGE_CACHE_ENABLED. */
	public static final String IMAGE_CACHE_ENABLED = "umap.imageCache.enabled";

	/** The Constant ADMIN_ROLE_NAME. */
	public static final String ADMIN_ROLE_NAME = "admin.role.name";

	/** The Constant ADMIN_ROLE_DESC. */
	public static final String ADMIN_ROLE_DESC = "admin.role.description";

	/** The Constant ADMIN_USER_NAME. */
	public static final String ADMIN_USER_NAME = "admin.user.username";

	/** The Constant ADMIN_USER_PASS. */
	public static final String ADMIN_USER_PASS = "admin.user.password";

	/** The Constant ADMIN_USER_EMAIL. */
	public static final String ADMIN_USER_EMAIL = "admin.user.email";

	/** The Constant USERMNGT_CONSTANTS_CLASSNAME. */
	public static final String USERMNGT_CONSTANTS_CLASSNAME = "userMngt.constants.classname";

	/** The Constant SERVICES_ENCRYPTION_ENABLED. */
	public static final String SERVICES_ENCRYPTION_ENABLED = "umap.services.encription.enabled";

	/** The Constant DEFAULT_ENCRYPTION_KEY. */
	public static final String DEFAULT_ENCRYPTION_KEY = "safd&%$234234%";

	/** The Constant UMAP_INTERCEPTOR_CLASSES. */
	public static final String UMAP_INTERCEPTOR_CLASSES = "umap.interceptor.classes";

	/** The Constant PERSISTANCE_UNIT_NAME. */
	public static final String PERSISTANCE_UNIT_NAME = "umap.persistance.unit.name";

	/** The Constant ADVERTISEMENT_IMPL_CLASS. */
	public static final String ADVERTISEMENT_IMPL_CLASS = "umap.advertisement.impl.class";

	/** The Constant IMAGE_REDUCER_INSTALL_PATH. */
	public static final String IMAGE_REDUCER_INSTALL_PATH = "imageReducer.graphicsMagic.installPath";

	/** The Constant SMAATO_SERVICE_URL. */
	public static final String SMAATO_SERVICE_URL = "smaato.service.url";
	
	/** The Constant APPLE_KEYSTORE_FILEPATH. */
	public static final String APPLE_KEYSTORE_FILEPATH = "apple.apsn.keystore.filePath";

	/** The Constant APPLE_KEYSTORE_PASSWORD. */
	public static final String APPLE_KEYSTORE_PASSWORD = "apple.apsn.keystore.password";
	
	/** The Constant GOOGLE_GCM_KEY. */
	public static final String GOOGLE_GCM_KEY = "google.gcm.serverkey";

	/** The Constant SMTP_USER. */
	public static final String SMTP_USER = "smtp.auth.user";

	/** The Constant SMTP_PASSWORD. */
	public static final String SMTP_PASSWORD = "smtp.auth.pwd";

	/** The Constant SMTP_CHARSET. */
	public static final String SMTP_CHARSET = "smtp.auth.charset";

	/** The Constant SMTP_HOST. */
	public static final String SMTP_HOST = "smtp.host";

	/** The Constant SMTP_PORT. */
	public static final String SMTP_PORT = "smtp.port";

	/** The Constant SMTP_FROM. */
	public static final String SMTP_FROM = "smtp.from";

	/** The Constant SMTP_FROMNAME. */
	public static final String SMTP_FROMNAME = "smtp.fromName";

	/** The Constant SMTP_REPLYTO. */
	public static final String SMTP_REPLYTO = "smtp.replyTo";

	/** The Constant SMTP_USESSL. */
	public static final String SMTP_USESSL = "smtp.useSsl";

	/** The Constant SMTP_USEAUTH. */
	public static final String SMTP_USEAUTH = "smtp.auth.useauth";

	/** The Constant SMTP_USEPWD. */
	public static final String SMTP_USEPWD = "smtp.usePwd";

	/** The Constant SOCKET_FACTORY_CLASS. */
	public static final String SOCKET_FACTORY_CLASS = "smtp.SSLSocketFactory.class";

	public static final String UMAP_IMAGE_DATA_CACHE = "umap.imageDataCache.name";

	public static final String UMAP_IMAGE_URL_CACHE = "umap.imageUrlCache.name";
	
	
}
