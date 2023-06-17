import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    private String login;
    private String senha;
    private Date dataRegistro;
    private String email;

    public Usuario() {}

    public Usuario(String login, String senha, String email, Date dataRegistro) {
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.dataRegistro = dataRegistro;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean verificarLogin() {
        ArrayList<Admin> admins = AdminRepository.getAdmins();
        boolean isLogin = false;

        for (Admin a : admins) {
            if (a.getLogin().equals(login) && a.getSenha().equals(senha)) {
                isLogin = true;
                break;
            }
        }

        System.out.printf("%s\n", isLogin ? "" : "Login ou senha incorretos!");

        return isLogin;
    }
}