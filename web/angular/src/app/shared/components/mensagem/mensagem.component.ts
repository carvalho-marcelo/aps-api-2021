import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-mensagem',
  templateUrl: './mensagem.component.html',
  styleUrls: ['./mensagem.component.scss']
})
export class MensagemComponent implements OnInit {

  constructor(private messageService: MessageService) { }

  ngOnInit(): void {
  }

  public apresentarMensagemSucesso(mensagem: string): void {
    this.messageService.add({
      severity: 'success',
      summary: 'Sucesso!',
      detail: mensagem
    });
  }

  public apresentarMensagemErro(mensagem: string): void {
    this.messageService.add({
      severity: 'error',
      summary: 'Erro!',
      detail: mensagem
    });
  }

}
