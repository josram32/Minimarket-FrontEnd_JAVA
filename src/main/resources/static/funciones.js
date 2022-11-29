function eliminar_cli(id, nom) {

	swal({
		  title: "¿Está seguro de eliminar al cliente " + nom + "?",
		  //text: "Once deleted, you will not be able to recover this imaginary file!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				  url:"/eliminar_cli/" + id,
				  success: function(res) {
					  console.log(res);
				  }
			  });
		    swal("Cliente eliminado", {
		      icon: "success",
		    }).then ((ok)=> {
				if (ok) {
					location.href="/cliente";
				}
			});
		  } else {
		    swal("No se eliminó cliente "+ nom);
		  }
		});
		
}

function eliminar_usu(id, nom, ape) {

	swal({
		  title: "¿Está seguro de eliminar al usuario " + nom+" "+ape+ "?",
		  //text: "Once deleted, you will not be able to recover this imaginary file!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				  url:"/eliminar_usu/" + id,
				  success: function(res) {
					  console.log(res);
				  }
			  });
		    swal("Usuario eliminado", {
		      icon: "success",
		    }).then ((ok)=> {
				if (ok) {
					location.href="/user";
				}
			});
		  } else {
		    swal("No se eliminó usuario "+ nom+" "+ape);
		  }
		});
		
}

function eliminar_prv(id, nom) {

	swal({
		  title: "¿Está seguro de eliminar al proveedor " + nom + "?",
		  //text: "Once deleted, you will not be able to recover this imaginary file!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				  url:"/eliminar_prv/" + id,
				  success: function(res) {
					  console.log(res);
				  }
			  });
		    swal("Proveedor eliminado", {
		      icon: "success",
		    }).then ((ok)=> {
				if (ok) {
					location.href="/proveedor";
				}
			});
		  } else {
		    swal("No se eliminó proveedor "+ nom);
		  }
		});
		
}

function eliminar_pro(id, nom) {

	swal({
		  title: "¿Está seguro de eliminar el producto " + nom + "?",
		  //text: "Once deleted, you will not be able to recover this imaginary file!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				  url:"/eliminar_pro/" + id,
				  success: function(res) {
					  console.log(res);
				  }
			  });
		    swal("Producto eliminado", {
		      icon: "success",
		    }).then ((ok)=> {
				if (ok) {
					location.href="/producto";
				}
			});
		  } else {
		    swal("No se eliminó producto "+ nom);
		  }
		});
		
}