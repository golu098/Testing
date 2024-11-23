package restAssured.ReqRes;

public class Data {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
public  Data(){}
    public Data(int id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    @Override
    public String toString() {
        return "Data{" +
                "email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

}
//class Users{
//    private int page;
//    private int per_page;
//    private int total;
//    private int total_pages;
//
//    Data data;
//    // Default constructor
//    public Users() {}
//    @JsonCreator
//    public Users(@JsonProperty("page") int page,
//                 @JsonProperty("per_page") int per_page,
//                 @JsonProperty("total") int total,
//                 @JsonProperty("total_pages") int total_pages,
//                 @JsonProperty("data") List<Data> data) {
//        this.page = page;
//        this.per_page = per_page;
//        this.total = total;
//        this.total_pages = total_pages;
//        this.data = data;
//    }
//
//    public int getTotal() {
//        return total;
//    }
//
//    public void setTotal(int total) {
//        this.total = total;
//    }
//
//    public int getPage() {
//        return page;
//    }
//
//    public void setPage(int page) {
//        this.page = page;
//    }
//
//    public int getPer_page() {
//        return per_page;
//    }
//
//    public void setPer_page(int per_page) {
//        this.per_page = per_page;
//    }
//
//    public int getTotal_pages() {
//        return total_pages;
//    }
//
//    public void setTotal_pages(int total_pages) {
//        this.total_pages = total_pages;
//    }
//
//    public List<Data> getData() {
//        return data;
//    }
//
//    public void setData(List<Data> data) {
//        this.data = data;
//    }
//
//}
class Support{
private String url;
private String text;
public Support(){}
    public Support(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Support{" +
                "url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

class Users{
    Data data;
    Support support;
    public Users(){}
    public Users(Data data, Support support) {
        this.data = data;
        this.support = support;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "Users{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }
}
