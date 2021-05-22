package Client.ViewModel;

import Client.Model.ModelFactory;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ViewModelFactory {
    private AdminVM adminVM;
    private LoginVM loginVM;
    private homepageVM homepageVM;
    private CreateAccountVM createAccountVM;
    private DetailVM detailVM;

    public ViewModelFactory(ModelFactory modelFactory) throws RemoteException, NotBoundException {
        adminVM=new AdminVM(modelFactory.getAdminModel());
        loginVM=new LoginVM(modelFactory.getLoginModel());
        homepageVM =new homepageVM(modelFactory.getCustomerModel());
        createAccountVM=new CreateAccountVM(modelFactory.getLoginModel());
        detailVM=new DetailVM(modelFactory.getCustomerModel());
    }

    public LoginVM getLoginVM() {
        return loginVM;
    }

    public AdminVM getAdminVM() {
        return adminVM;
    }

    public homepageVM getOverViewVM() {
        return homepageVM;
    }

    public CreateAccountVM getCreateAccountVM(){
        return createAccountVM;
    }

    public DetailVM getDetailVM(){
        return detailVM;
    }
}
