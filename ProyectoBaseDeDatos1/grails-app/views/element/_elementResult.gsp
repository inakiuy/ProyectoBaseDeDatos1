<div class="col-lg-12">
    <table class="table" id="tableElements" style="width: 1050px; display: none;">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Descripcion</th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${elements}" var="element" status="i">
            <tr>
                <td>${element.name}</td>
                <td>${element.description}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <hr>
</div>