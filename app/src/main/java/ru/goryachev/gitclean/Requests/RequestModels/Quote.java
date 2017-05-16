package ru.goryachev.gitclean.Requests.RequestModels;

/**
 * Created by ubuntudev on 05.05.17.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "site",
        "name",
        "desc",
        "link",
        "elementPureHtml"
})
public class Quote implements Parcelable {

    @JsonProperty("site")
    private String site;
    @JsonProperty("name")
    private String name;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("link")
    private String link;
    @JsonProperty("elementPureHtml")
    private String elementPureHtml;
    public final static Parcelable.Creator<Quote> CREATOR = new Creator<Quote>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Quote createFromParcel(Parcel in) {
            Quote instance = new Quote();
            instance.site = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.desc = ((String) in.readValue((String.class.getClassLoader())));
            instance.link = ((String) in.readValue((String.class.getClassLoader())));
            instance.elementPureHtml = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Quote[] newArray(int size) {
            return (new Quote[size]);
        }

    };

    @JsonProperty("site")
    public String getSite() {
        return site;
    }

    @JsonProperty("site")
    public void setSite(String site) {
        this.site = site;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    @JsonProperty("desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("elementPureHtml")
    public String getElementPureHtml() {
        return elementPureHtml;
    }

    @JsonProperty("elementPureHtml")
    public void setElementPureHtml(String elementPureHtml) {
        this.elementPureHtml = elementPureHtml;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(site);
        dest.writeValue(name);
        dest.writeValue(desc);
        dest.writeValue(link);
        dest.writeValue(elementPureHtml);
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "site='" + site + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", link='" + link + '\'' +
                ", elementPureHtml='" + elementPureHtml + '\'' +
                '}';
    }
}

