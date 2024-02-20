<script>

  import inserirUsuario from './components/InserirUsuario.vue';
  import mostrarUsuarios from './components/MostrarUsuarios.vue';

  export default {
    components: {
      inserirUsuario,
      mostrarUsuarios
    }
  }

</script>

<template>
  <div>
    <inserirUsuario />
    <mostrarUsuarios />
  </div>
</template>