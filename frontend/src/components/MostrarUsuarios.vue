<template>

    <div>
        <button @click="mostraUsuarios">Usuarios</button>
    </div>

  <div id="dados" style="display: none;">

    <!-- Cria a tabela -->
    <table style="border: 1px solid black;">
      <!-- Cabeçalho da tabela -->
        <thead>
          <tr style="border: 1px solid black;">
            <th>Nome</th>
            <th>Email</th>

            <th>Senha</th>
          </tr>
        </thead>

        <!-- Corpo da tabela -->
        <tbody>

          <!-- For que percorre a lista de usuarios criada na função  -->

          <tr v-for="usuario in usuarios" :key="usuario.id">
            <td style="border: 1px solid black; margin: 10px;">{{ usuario.nome }}</td>
            <td style="border: 1px solid black; margin: 10px">{{ usuario.email }}</td>
            <td style="border: 1px solid black; margin: 10px">{{ usuario.senha }}</td>
           

          </tr>
        </tbody>
      </table>
  </div>

</template>


<script>

import axios from 'axios';

export default {
    data() {
        return {
            usuarios: []
        }
    },
    methods: {
        mostraUsuarios() {
        axios.get('http://localhost:8085/users') 
        .then(response => {
            document.getElementById("dados").style.display = "inherit";
            this.usuarios = response.data

        })
        .catch(error => {
            console.log(error);
      })
    }
    }
}

</script>