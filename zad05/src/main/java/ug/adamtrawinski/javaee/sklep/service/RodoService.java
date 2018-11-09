package ug.adamtrawinski.javaee.sklep.service;

public class RodoService {
    private boolean processingData;
    private boolean sendingNewsletter;
    private boolean sellingData;

    public boolean isProcessingData() {
        return processingData;
    }

    public void setProcessingData(boolean processingData) {
        this.processingData = processingData;
    }

    public boolean isSendingNewsletter() {
        return sendingNewsletter;
    }

    public void setSendingNewsletter(boolean sendingNewsletter) {
        this.sendingNewsletter = sendingNewsletter;
    }

    public boolean isSellingData() {
        return sellingData;
    }

    public void setSellingData(boolean sellingData) {
        this.sellingData = sellingData;
    }
}
