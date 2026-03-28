# atividade pratica/main.py

from internal import firebase_auth
from internal import firebase_create_user
from internal import email_connect

def menu_principal():
	"""
	Função: Exibir um menu principal para o usuário com opções para cadastrar email, enviar confirmação de email e autenticar email.
	Retorno: Retorna a escolha do usuário como uma string.
	"""

	print("")
	print("MENU PRINCIPAL")    
	print("  1. cadastrar email")
	print("  2. enviar confirmação email")
	print("  3. autenticar email")
	print("  4. SIG IN FIRE BASE")
	print("  5. CRIAR USUÁRIO FIRE BASE")
	
	print("  0. Sair")
	print("")

	escolha = input("Escolha uma opção: ")
	return escolha

def cadastrar_email():
	"""
	Função: 
	Retorno:
	"""
	pass    
def enviar_confirmacao_email():
	"""
	Função: 
	Retorno:
	"""
	pass
def autenticar_email():
	"""
	Função: 
	Retorno:
	"""
	pass    


def main():
	"""
	Função: função principal. Loop da aplicação
	Retorno: 1 se erro senao null
	"""
	while True:
		escolha = menu_principal()
		match(escolha):
			case "1":
				print("Cadastrar email selecionado.")
				cadastrar_email()
				
			case "2":
				print("Enviar confirmação email selecionado.")
				enviar_confirmacao_email()

			case "3":
				print("Autenticar email selecionado.")
				autenticar_email()
			
			case "4":
				print("SING IN FIREBASE.")
				firebase_auth.firebase_sign_in()
			
			case "5":
				print("CRIAR USUÁRIO.")
				firebase_create_user.firebase_create_user()

			case "0":
				print("Saindo do programa.")   
				return

			case _:
				print("Opção inválida. Tente novamente.")



if __name__ == "__main__":
	main()