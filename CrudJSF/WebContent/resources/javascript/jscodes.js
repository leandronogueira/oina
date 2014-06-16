function closeDialogIfSucess(xhr, status, args, dialogWidget, dialogId) {
	if (args.validationFailed || args.KEEP_DIALOG_OPENED) {
		$('#'+dialogId).effect("bounce", {times : 4, distance : 20}, 100);
	} else {
		dialogWidget.hide();
	}
}

$( document ).ready(function() {
	$("input:text:eq(0):visible:enabled").focus(); //Foco no primeiro campo visível e habilitado do tipo 'texto' da página
});