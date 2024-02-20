<script>

import axios from 'axios';

export default {
  data() {
    return {
      NovoUsuario: {
        nome: '',
        email: '',
        senha: ''
      },

      usuarios: []
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
        console.log("Situação: ", response.data)

        this.NovoUsuario = {
          nome : '',
          email : '',
          senha : ''
        };
      })
      .catch(error => {
        console.error('Erro ao adicionar usuário:', error);
      });
    },

    mostraUsuarios() {
      axios.get('http://localhost:8085/users') 
      .then(response => {

        this.usuarios = response.data

      })
      .catch(error => {
        console.log(error);
      })
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

  <div>
    <button @click="mostraUsuarios">Usuarios</button>
  </div>

  <div id="dados">

    <!-- Cria a tabela -->
    <table style="border: 1px solid black;">
      <!-- Cabeçalho da tabela -->
        <thead>
          <tr style="border: 1px solid black;">
            <th>Nome</th>
            <th>Email</th>
          </tr>
        </thead>

        <!-- Corpo da tabela -->
        <tbody>

          <!-- For que percorre a lista de usuarios criada na função  -->

          <tr v-for="usuario in usuarios" :key="usuario.id">
            <td style="border: 1px solid black; margin: 10px;">{{ usuario.nome }}</td>
            <td style="border: 1px solid black; margin: 10px">{{ usuario.email }}</td>
           

          </tr>
        </tbody>
      </table>
  </div>
</template>