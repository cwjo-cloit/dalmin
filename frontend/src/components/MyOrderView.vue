<template>

    <v-data-table
        :headers="headers"
        :items="myOrder"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MyOrderView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "itemId", value: "itemId" },
                { text: "price", value: "price" },
                { text: "status", value: "status" },
            ],
            myOrder : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/myOrders'))

            temp.data._embedded.myOrders.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.myOrder = temp.data._embedded.myOrders;
        },
        methods: {
        }
    }
</script>

