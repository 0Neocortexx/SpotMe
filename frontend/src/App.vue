<script>

import axios from 'axios';

export default {
  data() {
    return {
      NovoUsuario: {
        nome: '',
        email: '',
        senha: ''
      }
    }
  },
  methods: {
    addUser() {
      axios.post('http://localhost:8085/cadastro/usuario', this.NovoUsuario, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then(response => {
        alert("Certo", response.data);

        this.NovoUsuario = {
          nome : '',
          email : '',
          senha : ''
        };
      })
      .catch(error => {
        console.error('Erro ao adicionar usuário:', error);
      });
    }
  }
}
</script>

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