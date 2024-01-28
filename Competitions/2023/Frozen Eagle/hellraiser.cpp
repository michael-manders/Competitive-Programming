#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <bits/stdc++.h>

#define PI atan(1)*4

using namespace std;

double cs;
double scs;
double sqrtPI = sqrt(PI);
double scs2;

double integral(double a, double b, double c,double p, double t, double t1)
{
    // printf("\n%lf %lf\n", cs, scs);
    double expo = -pow(p-b*c,2)/(cs);
    double er = (-b+c*c*t-c*p+t)/scs;
    double er1 = (-b+c*c*t1-c*p+t1)/scs;
    double ans = a*(sqrtPI * exp(expo) * (erf(er)-erf(er1))) / (scs2);
    // printf("\na %.2lf b %.2lf c %.2lf p %.2lf t %.2lf t1 %.2lf\ncs %.2lf scs %.2lf expo %.2lf er %.2lf er1 %.2lf\n%lf\n", a,b,c,p,t,t1,cs, scs, expo, er, er1, ans);
    return ans;
}
typedef struct func {
    double a;
    double b;
    double e;
} func;

int main() {
    int t;
    scanf("%d", &t);
    for(int j = 0;j<t;j++) {
        int n;
        scanf("%d", &n);
        vector<func> list;
        for(int i = 0; i < n; i++) {
            double a, b, c;
            scanf("%lf %lf %lf", &a, &b, &c);
            list.push_back({a, b, c});
        }
        double a, b, c, d;
        scanf("%lf %lf\n%lf %lf", &a, &b, &c, &d);
        double slope = 1.0*(d-b) / (c-a);
        cs = slope*slope+1;
        scs = sqrt(cs);
        scs2 = 2*scs;
        if(c - a == 0) slope = 0;
        // double l = line(1,slope);
        double good = 0;
        double bad = 0;
        double f = slope*-a+b;
        for(auto &fun : list) {
            double in = integral(fun.a,fun.b,slope,fun.e-f, c,a);
            if(fun.b == a && fun.e == b ||  fun.b == c && fun.e == d) {
                good += in;
            }
            else {
                bad += in;
            }
        }
        // printf("\n_________________________\n");
        // printf("%lf\n%lf\n", good, bad);
        printf("Day %d: ", j+1);
        if((bad) > (good)) printf("Joe will not work");
        else if((bad) < (good)) printf("Joe will work");
        else printf("Meh...");
        printf("\n");
    }
    return 0;
}
