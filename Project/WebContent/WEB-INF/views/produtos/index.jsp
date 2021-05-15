<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" >
<div class="container mt-5">
<h1 class="mb-5">Cadastro de Produto</h1>
<form action="cadastroproduto" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Descrição</label>
    <input type="text" class="form-control" id="campo_descricao" name="campo_descricao">
  </div>
 <div class="form-group">
    <label for="exampleInputMarca">Marca</label>
    <input type="text" class="form-control" id="campo_marca" name="campo_descricao">
  </div>
   <div class="form-group">
    <label for="exampleInputCor">Cor</label>
    <input type="text" class="form-control" id="campo_cor" name="campo_descricao">
  </div>
    <div class="form-group">
    <label for="exampleInputComodato">Valor comodato</label>
    <input type="number" class="form-control" id="campo_comodato" name="campo_descricao">
  </div>
  <button type="submit" class="btn btn-primary">Salvar!</button>
</form>
</div>