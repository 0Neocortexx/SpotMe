<template>

<div>
    <h2>Adicionar Novo Usuário</h2>
    <form @submit.prevent="addUser">
      <label for="nome">Nome:</label>
      <input type="text" id="nome" v-model="NovoUsuario.nome" required><br>
      <label for="email">Email:</label>
      <input type="email" id="email" v-model="NovoUsuario.email" required><br>
      <label for="senha">Senha:</label>
      <input type="password" id="senha" v-model="NovoUsuario.senha" required><br>
      <button type="submit">Adicionar Usuário</button>
    </form>
</div>


</template>


<script>

// Importa a biblioteca Axios para Requisições 
import axios from 'axios';

// Exporta um objeto Vue que define um componente
export default {
  // Define os dados do componente
    data() {
        return {
          // Cria o objeto NovoUsuario
            NovoUsuario: {
                nome: '',
                email: '',
                senha: ''
            }
    }
  },
  methods: {
    // Define o método addUser para adicionar um usuario ao banco de dados da API
    addUser() {
      // Realiza uma requisição POST na rota fornecida
      axios.post('http://localhost:8085/cadastro/usuario', this.NovoUsuario, { // Envia os dados presentes no objeto NovoUsuario
        
        // Tipo do arquivo enviado a API
        headers: {
          'Content-Type': 'application/json'
        }
      })
      // Se a requisição for bem sucedida
      .then(response => {
        
        // Exibe a situação no console
        console.log("Situação: ", response.data)

        // Limpa o objeto NovoUsuario para novas requisições
        this.NovoUsuario = {
          nome : '',
          email : '',
          senha : ''
        };
      })
      // Se a requisição for mal sucedida
      .catch(error => {
        // exibe o erro no console
        console.error('Erro ao adicionar usuário:', error);
      });
    }
    }
}
</script>