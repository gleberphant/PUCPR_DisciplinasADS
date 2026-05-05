# criar usuário no firebase authentication

import firebase_admin
from firebase_admin import credentials
from firebase_admin import auth

def create_firebase_user():
	"""
	Função: cria um usuário no firebase authentication
	Retorno: retorna o objeto do usuário criado ou None em caso de erro
	"""
	try:
		cred = credentials.Certificate("../key/pucpr-cybersec-firebase-adminsdk-fbsvc-9efe78029f.json")
		firebase_admin.initialize_app(cred)
	except Exception as e:
		print("Erro ao inicializar o Firebase Admin: ", e)
		exit()

	my_email = input("Digite seu e-mail: ")
	my_password = input("Digite sua senha, com pelo menos 6 caracteres: ")

	try:
		login = auth.create_user(email=my_email, password=my_password)


	except Exception as e:
		print("Erro ao criar usuário: ", e)
		exit()


	print("Resultado: ", login.uid)
	print("Resultado: ", login.email)
	print("Resultado: ", login.user_metadata)

if __name__ == "__main__":
	create_firebase_user()