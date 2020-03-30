import {Component, OnInit} from '@angular/core';
import {MessageService} from 'primeng/api';
import {AppInjectorService} from '../app-injector.service';

@Component({
    template: '',
    providers: [MessageService]
})
export abstract class BaseComponent {

    //protected messageService: MessageService;

    constructor(protected messageService: MessageService) {
        // Manually retrieve the dependencies from the injector
        // so that constructor has no dependencies that must be passed in from child

        /*const injector = AppInjectorService.getInjector();
        console.log(injector)
        this.messageService = injector.get(MessageService);
        console.log(3)*/
    }

    protected analyzeResponseStatus(status: number, successSummary: string = '', successMessage: string = '') {
        let severity: string;
        let summary: string;
        let detail: string;
        if (status === 200) {
            severity = 'success';
            summary = successSummary;
            detail = successMessage;
        } else if (status === 401 || status === 403) {
            severity = 'warn';
            summary = 'Keine Berechtigung';
            detail = 'Sie verfügen nicht über die notwendige Berechtigung, diesen Service zu nutzen';
        } else if (status === 503) {
            severity = 'warn';
            summary = 'Nicht verfügbar';
            detail = 'Dieser Service ist derzeit nicht verfügbar.';
        } else if (status >= 400) {
            severity = 'error';
            summary = 'Fehler';
            detail = 'Unerwarteter Fehler ' + status;
        }
        this.messageService.add({
            key: 'http-status',
            severity: severity,
            summary: summary,
            detail: detail
        });
    }
}
