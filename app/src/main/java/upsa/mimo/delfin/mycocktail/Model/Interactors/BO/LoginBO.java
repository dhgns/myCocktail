package upsa.mimo.delfin.mycocktail.Model.Interactors.BO;


public class LoginBO {
    public UserBO userBO;
    public ErrorLog errorLog;

    public LoginBO(UserBO user, ErrorLog error){
        this.userBO = user;
        this.errorLog = error;
    }

    public LoginBO(){}
}
