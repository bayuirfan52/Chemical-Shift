package kimia.lib;

/**
 * Library interface to manage progressbar in Main class
 * @author BAYU IRFAN
 */
public interface LibraryView {
    /**
     * Used to update progress on CH group
     * @param progress 
     */
    void updateProgressCH(int progress);
    
    /**
     * Used to update progress on H group
     * @param progress 
     */
    void updateProgressH(int progress);
    
    /**
     * Listener when progress in CH group process is finished
     */
    void progressHOnCompleteListener();
    
    /**
     * Listener when progress in H group process is finished
     */
    void progressCHOnCompleteListener();
}