import { Component, Input, OnInit } from '@angular/core';

@Component({
    selector: 'app-github-corner',
    templateUrl: './github-corner.component.html',
    styleUrls: ['./github-corner.component.scss']
})
export class GithubCornerComponent implements OnInit {

    @Input('url') url: string;

    constructor() { }

    ngOnInit(): void {
        if (!this.url) {
            this.url = "https://github.com/carvalho-marcelo"
        }
    }

}
