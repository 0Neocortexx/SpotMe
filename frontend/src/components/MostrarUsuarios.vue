<template>

  <!-- Botão que exibe as informações do banco de dados -->
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

// Importa a biblioteca axios
import axios from 'axios';

// Exporta um objeto Vue que define um componente
export default {

  // Define os dados do componente
    data() {
        return {
          // Array que armazenará os dados fornecidos pela API
            usuarios: []
        }
    },
    // Define os metodos 
    methods: {
      // Cria o método mostraUsuarios
        mostraUsuarios() {
        axios.get('http://localhost:8085/users') // Faz uma requisição GET, pegando as informações de todos os usuários
        // Se a requisição for bem sucedida
        .then(response => {
           // Exibe a tabela de usuarios 
            document.getElementById("dados").style.display = "inherit";
            
            // Armazena os dados recebidos da API na array 
            this.usuarios = response.data

        })
        // Se a requisição falhar
        .catch(error => {
          // Exibe o erro no console
            console.log(error);
      })
    }
    }
}

</script>