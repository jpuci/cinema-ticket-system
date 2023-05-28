import {Component} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Code} from "../../model/code";

@Component({
  selector: 'bs-code-ticket',
  templateUrl: './code-ticket.component.html',
  styleUrls: ['./code-ticket.component.scss']
})
export class CodeTicketComponent {
  code: Code = {code: "abc"};

  constructor(private readonly activatedRoute: ActivatedRoute) {
    this.code = this.activatedRoute.snapshot.data['code'];
  }
}
