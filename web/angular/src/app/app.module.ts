import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { RippleModule } from 'primeng/ripple';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DividerModule } from 'primeng/divider';
import { ConsultarDeputadoComponent } from './deputado/pages/consultar-deputado/consultar-deputado.component';
import { GithubCornerModule } from './shared/components/github-corner/github-corner.module';


@NgModule({
    declarations: [
        AppComponent,
        ConsultarDeputadoComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ButtonModule,
        RippleModule,
        CardModule,
        DividerModule,
        GithubCornerModule
    ],
    providers: [],
    bootstrap: [AppComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
