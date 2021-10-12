import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GithubCornerComponent } from './github-corner.component';



@NgModule({
    declarations: [GithubCornerComponent],
    imports: [
        CommonModule
    ],
    exports: [
        GithubCornerComponent
    ]
})
export class GithubCornerModule { }
