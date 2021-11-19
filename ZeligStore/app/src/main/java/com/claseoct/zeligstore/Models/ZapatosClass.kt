package com.claseoct.zeligstore.Models

data class ZapatosClass(var idzapato:Int, var talla:Double, var color:String, var precio:Double,
                        var url:String, var idcategoria:CategoriaClass, var idmodelo:ModeloClass,
                        var idmarca:MarcaClass,var idestilo:EstiloClass) {
}