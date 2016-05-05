package uniandes.fabricasw.ecotouring.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemCSV implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long itemId;
	//private String itemType;
	//private String status;
	private String name;
	/*private String description;
	private int price;
	private int score;
	private String category;
	private String supplier;
	private String tags;
	private String urlImage;
	private String contentType;
	private int queryCounter;
	private int conversationsCount;
	private int CommentsCount;
	private int ContentCount;
	private int transactionCount;
	private int packageCount;*/
	
	public Long getItemId() {
		return itemId;
	}
	
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/*public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getQueryCounter() {
		return queryCounter;
	}
	public void setQueryCounter(int queryCounter) {
		this.queryCounter = queryCounter;
	}
	public int getConversationsCount() {
		return conversationsCount;
	}
	public void setConversationsCount(int conversationsCount) {
		this.conversationsCount = conversationsCount;
	}
	public int getCommentsCount() {
		return CommentsCount;
	}
	public void setCommentsCount(int commentsCount) {
		CommentsCount = commentsCount;
	}
	public int getContentCount() {
		return ContentCount;
	}
	public void setContentCount(int contentCount) {
		ContentCount = contentCount;
	}
	public int getTransactionCount() {
		return transactionCount;
	}
	public void setTransactionCount(int transactionCount) {
		this.transactionCount = transactionCount;
	}
	public int getPackageCount() {
		return packageCount;
	}
	public void setPackageCount(int packageCount) {
		this.packageCount = packageCount;
	}*/
}
