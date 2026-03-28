import pyrebase
import sys


def firebase_sign_in():
	# Esta é a configuração do CLIENTE (Web), a mesma que você tinha.
	firebaseConfig = {
	"apiKey": "AIzaSyAoT3nm0xBceUlxzqMFhwIFEn37Zwk6tYM",
	"authDomain": "pucpr-cybersec.firebaseapp.com",
	"projectId": "pucpr-cybersec",
	"databaseURL": "https://pucpr-cybersec-default-rtdb.firebaseio.com/",
	"storageBucket": "pucpr-cybersec.firebasestorage.app",
	"messagingSenderId": "849207810005",
	"appId": "1:849207810005:web:6e3a5d349ae69363300f5c",
	"measurementId": "G-GCZRMGYSPK"
	}

	try:
		# Inicializa o Pyrebase (API Cliente)
		firebase = pyrebase.initialize_app(firebaseConfig)
		auth = firebase.auth()
	except Exception as e:
		print(f"Erro ao inicializar Pyrebase: {e}")
		sys.exit(1)


	# Obter credenciais
	user_email = input("Digite seu e-mail para login: ")
	password = input("Digite sua senha: ")

	# Tentar o sign-in
	try:
		# Este é o método de login do Pyrebase (Cliente)
		user_session = auth.sign_in_with_email_and_password(user_email, password)
		
		print("\nLogin realizado com sucesso!")
		
		# A 'user_session' é um dicionário contendo os tokens do usuário
		print(f"Usuário (localId): {user_session['localId']}")
		
		# O idToken é a prova criptográfica de que o usuário está autenticado.
		# Em uma aplicação real, você enviaria este token para o seu backend

	except Exception as e:
		# Pyrebase geralmente retorna erros HTTP em um formato JSON
		print(f"\nErro no Login: {e}")
		print("(Verifique se o e-mail existe e se a senha está correta)")
		sys.exit(1)

def acessar_realtime_database(firebase: pyrebase.Firebase):

	# Acessar o Realtime Database
	print("\n *Acessando o Realtime Database...", end= "")

	try:
		
		db = firebase.database()
		print("Acesso ao Realtime Database realizado com sucesso!")    
	except Exception as e:
		print(f"Erro ao acessar o Realtime Database: {e}")
		sys.exit(1)



	print("\n *Inserindo dados no Realtime Database...", end="")
	try:
		dados = {
			"nome": "Usuário de Teste",
			"email": "Email de Teste",
			"nivel_acesso": "padrão"
		}
		
		db.child("usuarios").push(dados)
		print("Dados adicionados ao Realtime Database com sucesso!")

	except Exception as e:
		print(f"Erro ao adicionar dados ao Realtime Database: {e}") 



	print("\n *Lendo dados do Realtime Database...", end="")
	try:
		
		leitura = db.child("usuarios").get()
		print(f"Dados lidos do Realtime Database: {leitura}")
	except Exception as e: 
		print(f"Erro ao ler dados do Realtime Database: {e}")

if __name__ == "__main__":
	firebase_sign_in()