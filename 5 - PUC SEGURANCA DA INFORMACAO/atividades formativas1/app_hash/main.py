import csv
import hashlib


def menu_principal():
	"""
	Função: Exibir um menu principal para o usuário com opções para cadastrar email, enviar confirmação de email e autenticar email.
	Retorno: Retorna a escolha do usuário como uma string.
	"""

	print("")
	print("MENU PRINCIPAL")
	print("  1. cadastrar usuário")
	print("  2. autenticar usuário")
	print("  0. Sair")
	print("")

	escolha = input("Escolha uma opção: ")
	return escolha

def testes():
	nome = "handerson gleber"
	hash_nome = hashlib.md5(nome.encode()).hexdigest()
	print(f" {hash_nome}")



def cadastrar_usuario():
	"""
	Função:
	Retorno:
	"""
	usuario = input("Informe seu nome: ")
	email = input("Informe seu email: ")
	senha = input("Informe sua senha: ")

	hash_email = hashlib.md5(email.encode()).hexdigest()
	hash_senha = hashlib.md5(senha.encode()).hexdigest()

	with open("usuarios.txt", "a") as arquivo:
		writer = csv.writer(arquivo)
		writer.writerow([usuario, hash_email, hash_senha])

	print("Usuário cadastrado com sucesso!")


def autenticar_usuario():
	"""
	Função:
	Retorno:
	"""

	usuario = input("Digite o nome do usuário: ")
		
	with open("usuarios.txt", "r") as arquivo:
		reader = csv.reader(arquivo)
		
		for row in reader:
		
			if len(row) < 3:
				print("erro no arquivo de usuarios")
				continue
		
			elif row[0] == usuario:
				print("Usuario encontrado!")
				senha = input("Digite a senha do usuário: ")
				hash_senha = hashlib.md5(senha.encode()).hexdigest()
				
				if row[2] == hash_senha:
					print("")
					print("......................................")
					print(".. Usuário autenticado com sucesso! ..")
					print("......................................")
					return
				else:
					print("Senha incorreta!")
			
			
		print("Autenticação Inválida!!")



def main():
	"""
	Função: função principal. Loop da aplicação
	Retorno: 1 se erro senao null
	"""
	while True:

		escolha = menu_principal()

		match(escolha):
			case "1":
				print("Cadastrar usuário selecionado.")
				cadastrar_usuario()

			case "2":
				print("Autenticar usuário selecionado.")
				autenticar_usuario()
			case "3":
				testes()
			case "0":
				print("Saindo do programa.")
				return


if __name__ == "__main__":
	main()