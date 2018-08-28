package upsa.mimo.delfin.mycocktail.Model.Repositories.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorComm {

    public enum Status { ERROR, NO_ERROR, INVALIDAD_SESSION};
    public enum Source { FACEBOOK };

    public String msg;
    public Status status;
    public Source source;

    public ErrorComm(Status status, Source source, String msg){
        this.status = status;
        this.source = source;
        this.msg = msg;
    }

}
