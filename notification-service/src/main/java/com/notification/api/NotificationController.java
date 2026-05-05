package com.notification.api;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final JavaMailSender mailSender;
    
    @Value("${telegram.bot.token}")
    private String botToken;
    
    @Value("${telegram.chat.id}")
    private String chatId;

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        try {
            // 1. Send Email
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(request.getEmail());
            message.setSubject("Nueva Notificación de E-Commerce");
            message.setText(request.getMessage());
            mailSender.send(message);

            // 2. Send Telegram
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.telegram.org/bot" + botToken + "/sendMessage?chat_id=" + chatId + "&text=" + request.getMessage();
            restTemplate.getForObject(url, String.class);

            return ResponseEntity.ok("Notificaciones enviadas exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error enviando notificación: " + e.getMessage());
        }
    }
}

@Data
class NotificationRequest {
    private String email;
    private String message;
}
