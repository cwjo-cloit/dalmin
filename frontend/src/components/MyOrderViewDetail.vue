<template>

    <v-card outlined>
        <v-card-title>
            MyOrder # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="ItemId" v-model="item.itemId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Price" v-model="item.price" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MyOrderViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/myOrders/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

