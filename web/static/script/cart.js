function editCart(cartItem, buyCount) {

    window.location.href = "cart.do?operate=editCart&cartItemId=" + cartItem + "&buyCount=" + buyCount;


}


window.onload = function () {
    var vue = new Vue({
        el: "#cart_div",
        data: {
            cart: {
            }


        },
        methods: {
            getCart: function () {
                axios({
                    method: "POST",
                    url: "cart.do",
                    params: {
                        operate: 'cartInfo'
                    }
                }).then(function (value) {
                    {
                        console.log(value.data)
                        console.log(value)
                        var cart = value.data
                        vue.cart = cart;
                    }
                }).catch(function (reason) {
                    console.log(reason.data)
                })

            },
            editCart:function(cartItem, buyCount) {

                // window.location.href = "cart.do?operate=editCart&cartItemId=" + cartItem + "&buyCount=" + buyCount;

                axios({
                    method: "POST",
                    url: "cart.do",
                    params: {
                        operate: 'editCart',
                        cartItemId:cartItem,
                        buyCount:buyCount

                    }
                }).then(function (value) {
                    {
                        vue.getCart()
                    }
                }).catch(function (reason) {
                    console.log(reason.data)
                })
            },
            checkout:function (){

                alert("你的购物车为空,无法结账")
            }


        },
        mounted: function () {
            this.getCart()
        }

    })


}