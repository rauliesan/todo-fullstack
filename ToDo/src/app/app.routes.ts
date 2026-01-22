import { Routes } from '@angular/router';
import { Login } from './pages/login/login';
import { Register } from './pages/register/register';
import { Todo } from './pages/todo/todo';
import { Landing } from './pages/landing/landing';

export const routes: Routes = [
    {path: '', component: Landing},
    {path: 'login', component: Login},
    {path: 'register', component: Register},
    {path: 'todo', component: Todo},
    {path: '**', redirectTo: ''}
];
