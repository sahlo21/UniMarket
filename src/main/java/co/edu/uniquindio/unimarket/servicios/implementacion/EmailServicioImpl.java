package co.edu.uniquindio.unimarket.servicios.implementacion;


import co.edu.uniquindio.unimarket.modelo.dto.EmailDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class EmailServicioImpl implements EmailServicio {
    private final JavaMailSender javaMailSender;

    @Override
    public void enviarEmail(EmailDTO emailDTO) throws Exception{
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);
        helper.setSubject(emailDTO.getAsunto());
        helper.setText(emailDTO.getCuerpo(), true);
        helper.setTo(emailDTO.getDestinatario());
        helper.setFrom("no_reply@dominio.com");
        javaMailSender.send(mensaje);
    }


}