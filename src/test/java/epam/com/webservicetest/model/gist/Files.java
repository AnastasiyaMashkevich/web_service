package epam.com.webservicetest.model.gist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Files {

    @JsonProperty("file.txt")
    private FileTxt fileTxt;

    public Files(){

    }
    public Files(FileTxt fileTxt){
        this.fileTxt =  fileTxt;
    }

    @JsonProperty("file1.txt")
    public FileTxt getFileTxt() {
        return fileTxt;
    }

    @JsonProperty("file1.txt")
    public void setFileTxt(FileTxt fileTxt) {
        this.fileTxt = fileTxt;
    }

}
