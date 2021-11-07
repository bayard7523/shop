import "../styles/style.sass"
import swal from 'sweetalert';

const addCategory_button = document.querySelector("#addCategory");

addCategory_button.addEventListener('click', ()=>{
    swal({
        title: "Are you sure?",
        text: "Аfter creating a category, you can delete or change it",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((willDelete) => {
            if (willDelete) {
                swal("Category has been added!", {
                    icon: "success",
                });
            }
        });
})