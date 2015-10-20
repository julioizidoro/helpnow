package br.com.travelmate.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EnviarEmailBean {

    private HtmlEmail email;
    private String notificacao;
    private String corpo;
    private String destinatario;
    private String titulo;

    public EnviarEmailBean(String notificacao, String destinatario, String titulo) {
        this.notificacao = notificacao;
        this.destinatario = destinatario;
        this.titulo = titulo;
        criarCorpoEmail();
    }

    public void enviarEmail() {
        email = new HtmlEmail();
        email.setHostName("smtp.travelmate.com.br");
        //email.setStartTLSEnabled(true);
        email.setSmtpPort(587);
        //email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("ti@travelmate.com.br", "20SimpleS78"));
        try {
            email.setFrom("systm@travelmate.com.br");
            listarDestinos();
        } catch (EmailException ex) {
            Logger.getLogger(EnviarEmailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        email.setSubject("Informativo SysTM");
        try {
            email.setHtmlMsg(corpo);
        } catch (EmailException ex) {
            Logger.getLogger(EnviarEmailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(EnviarEmailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HtmlEmail getEmail() {
        return email;
    }

    public void setEmail(HtmlEmail email) {
        this.email = email;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(String notificacao) {
        this.notificacao = notificacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void listarDestinos() {
        try {
            email.addTo(destinatario);
        } catch (EmailException ex) {
            Logger.getLogger(EnviarEmailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void criarCorpoEmail() {
        corpo = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title>Help Now</title>\n" +
                "<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +"<style>\n" +
                "img, embed, object, video{\n" +"    max-width: 100%;\n" +
                "    height: auto;\n" +"}\n" +
                "*{margin:0; padding:0; list-style: none; text-decoration: none; font-family: arial, sans-serif; font-size: 12px; color: #333}\n" +
                "h1, h2, h3{font-size: 24px; color: #1c7d67}\n" +
                ".header{height: 155px; background: #fff}\n" +
                ".page-header{width: 100%; float: left; position: relative; margin: 0 0 5px; }\n" +
                ".page-header .texto-destacado{width: 575px; text-align: justify; float: left; padding: 30px 30px 80px; color: #fff; font-size: 15px; line-height: 18px; height: 218px; background: #0a6e1d; box-sizing: border-box;}\n" +
                ".page-header .img-destacada{float: right; width: 365px; height: 218px; overflow: hidden; background: #d7dee4;}\n" +
                ".page-header .pg-head-link{position: absolute; top: 20px; right: 0; background: #00704f; color: #fff; display: block; padding: 10px; font-size: 20px;}\n" +
                "</style></head><body>\n" +
                "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "  <tr><td></td></tr> \n" +
                "  <tr><td width=\"450\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"background-image: url(http://www.travelmate.com.br/logoescola/fundo.png);\"><img src=\"http://www.travelmate.com.br/logoescola/hn_logobranco.png\" />\n" +
                "      <tr> <tr><td><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tr>\n" +
                "            <td bgcolor=\"#00704F\"><div align=\"center\"><span style=\"font-size:20px;color: #fff\"><p>&nbsp;</p></span>\n" +
                "            </div></td></tr></table></td>\n" +
                "      </tr><td width=\"100%\" bgcolor=\"#AFCA0B\"><p style=\"text-align: center;font-size: 24px;font: bold\" ><strong >"+titulo+"</strong></p></td></tr><tr> <td><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n" +
                "           <tr><td><table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"><tr> <td><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                  <tr><td width=\"123\"><p></p></td> </tr></table></td>  </tr></table></td> </tr> </table></td>\n" +
                "      </tr><tr> <td><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tr><td >\n" +
                "            <p class=\"curso-exterior\"><span class=\"curso-exterior\"><br></br>\n" +
                "                 <strong style=\"margin-left: 5%\">"+ notificacao +"</strong><br /></span></p>\n" +
                "                      </td><br></br> </tr></table> </td> </tr><tr>\n" +
                "        <td><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n" +
                "          <br></br><tr><td width=\"20\"><p>&nbsp;</p></td><td><table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\n" +
                "                      <tr><td><table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"5\" style=\"background: #fff\"><tr><td><p><span >Suporte</span></p></td>\n" +
"                    </tr><tr><td><p><strong><span style=\"color:#114A3D;\">Help</span><span style=\"color:#AFCA0B;\"> Now / <a href=\"mailto:ti@travelmate.com.br\"  style=\"color:#366\">hn@travelmate.com.br</a></span></strong></p></td>\n" +
                "                    </tr></table></td></tr> </table></td><td>&nbsp;</td> <td width=\"20\"><p>&nbsp;</p></td></tr>\n" +
                "          </table></td></tr> <tr><td><div align=\"center\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n" +
                "            <tr> <td>&nbsp;</td> </tr></table></div></td> </tr>\n" +
                "    </table></td></tr></table></body></html>\n" +
                "";
    }
}
