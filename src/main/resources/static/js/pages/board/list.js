$(function () {
   BoardList.init();
});

var BoardList = (function () {

    var datatable;
    var $searchForm;
    
    function _init() {
        $searchForm = $('#searchForm');
        datatable = _initDatatable($('#datatable'));

        $("#title, #writer").on("keyup",function(key){
            if(key.keyCode == 13) {
                _search();
            }
        })
    
        $('#searchBtn').on('click', function () {
            _search();
        })
    
        $('#createBtn').on('click', function () {
            location.href='/board/create';
        })
        
        _search();
    }

    function _search() {
        _getBoardListAjax(_setData);
    }

    function _initDatatable($datatable) {
        return $datatable.DataTable({
            columns: [
                {data: "boardId"},
                {data: "title"},
                {data: "writer"},
                {data: "isVisible"},
            ],
            language: {
                url: '//cdn.datatables.net/plug-ins/1.13.6/i18n/ko.json',
            }
        });
    }

    function _getBoardListAjax(callback) {
        $.ajax({
            url: "/board/api/list",
            type: "POST",
            data: $searchForm.serialize(),
            success: function(res) {
                callback(res.content);
            }
        })
    }

    function _setData(boardList) {
        datatable.clear().draw();
        datatable.rows.add(boardList);
        datatable.columns.adjust().draw();
    }
    
    function _clearData() {
        datatable.clear().draw();
    }

    return {
        init : _init
    }
})();