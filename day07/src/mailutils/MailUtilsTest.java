package mailutils;

import javax.mail.MessagingException;

public class MailUtilsTest {
    public static void main(String[] args) throws MessagingException {
        MailUtils.sendMail("hz_liuzb@163.com", "<h1>带标签的html内容</h1>", "邮件主题");
    }
}
