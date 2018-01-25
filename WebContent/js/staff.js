
$("a").click(function () {
    $.get($(this).attr("href"), function (r) {
        $("#content").html(r);
    }, "jsp");
    return false;
});
$(function() {
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;

		// Variables privadas
		var links = this.el.find('.link');
		// Evento
		links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
	}

	Accordion.prototype.dropdown = function(e) {
		var $el = e.data.el;
			$this = $(this),
			$next = $this.next();

		$next.slideToggle();
		$this.parent().toggleClass('open');

		if (!e.data.multiple) {
			$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
		};
	};

	var accordion = new Accordion($('#accordion'), false);
});

function delstaff(){
	var r=confirm("确认是否删除！");
	if (r==true)
	  {
		return true;
	  }
	else{
		return false;
	}
}