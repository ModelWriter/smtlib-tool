package eu.modelwriter.smtlib.texteditor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import eu.modelwriter.smtlib.AbstractPreference;
import eu.modelwriter.smtlib.Log;
import eu.modelwriter.smtlib.Utils;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "eu.modelwriter.smtlib.texteditor"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/** The shared instance of the plug-in utils methods */
	/*@NonNull*/
	public static Utils utils;
	
	/** The shared instance of a plug-in Log for the whole plug-in */
	/*@NonNull*/
	public static Log log;
	
	/** The option to print out verbose diagnostic information for the plug-in*/
	public static boolean verbose = false;
	
	/**
	 * The constructor
	 */
	public Activator() {
	    utils = new Utils();
	    log = new Log();
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);

	    // Listens for Preference page changes and updates the SMT Configuration accordingly
	    AbstractPreference.addListener(new AbstractPreference.Listener() { 
	    	@Override
	    	public void run() { 
	    		// The following line also extracts and sets Activator.verbose
	    	}
	    });
	    
	    if (verbose) Activator.log.logln("SMT UI plugin started");
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
