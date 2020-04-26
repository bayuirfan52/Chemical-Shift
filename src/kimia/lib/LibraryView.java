package kimia.lib;

public interface LibraryView {
    void updateProgressCH(int progress);
    void updateProgressH(int progress);
    void progressHOnCompleteListener();
    void progressCHOnCompleteListener();
}