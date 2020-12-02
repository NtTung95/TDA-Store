package Model;

public class TypeAccount {
    int typeAccountId;
    String typeOfAccount;

    public TypeAccount() {
    }

    public TypeAccount(int typeAccountId, String typeOfAccount) {
        this.typeAccountId = typeAccountId;
        this.typeOfAccount = typeOfAccount;
    }

    public int getTypeAccountId() {
        return typeAccountId;
    }

    public void setTypeAccountId(int typeAccountId) {
        this.typeAccountId = typeAccountId;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }
}
