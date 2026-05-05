from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText


def send_email():
	server = "smtp.gmail.com"
	port = 587
	username = ""
	password = ""

	mail_from = ""
	mail_to = ""
	mail_subject = "Segurança da Tecnologia da Informação"
	mail_body = "Olá Mundo, Python é Legal!!"

	mensagem = MIMEMultipart()
	mensagem['From'] = mail_from
	mensagem['To'] = mail_to
	mensagem['Subject'] = mail_subject
	mensagem.attach(MIMEText(mail_body, 'plain'))

	connection = smtplib.SMTP(server, port)
	connection.starttls()
	connection.login(username,password)
	connection.send_message(mensagem)
	connection.quit()

if __name__ == "__main__":
	send_email()    